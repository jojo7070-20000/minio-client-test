package main

import (
	"github.com/minio/minio-go/v6"
	"log"
)

//
// https://docs.min.io/cn/golang-client-quickstart-guide.html
// http://local-minio.com:9002
//
func main() {
	endpoint := "local-minio.com:9002"
	accessKeyID := "12345678"
	secretAccessKey := "12345678"
	useSSL := false //true

	// 初使化 minio client对象。
	minioClient, err := minio.New(endpoint, accessKeyID, secretAccessKey, useSSL)
	if err != nil {
		log.Fatalln(err)
	}

	log.Printf("%#v\n", minioClient) // minioClient初使化成功

	log.Println("==========================")

	bu, eB := minioClient.ListBuckets()

	log.Println("err:%#v\n", eB)
	log.Printf("桶列表：%#v\n", bu) // minioClient初使化成功

}
