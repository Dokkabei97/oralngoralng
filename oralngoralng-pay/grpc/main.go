package grpc

import (
	"google.golang.org/grpc"
	"log"
	"net"
	"pay/proto"
)

const PORT = ":9000"

type server struct {
	proto.PayServiceServer
}

func main() {
	listen, err := net.Listen("tcp", PORT)
	if err != nil {
		log.Println(err)
	}
	s := grpc.NewServer()
	proto.RegisterPayServiceServer(s, &server{})

	if err := s.Serve(listen); err != nil {
		log.Println(err)
	}
}
