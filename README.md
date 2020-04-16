# cotacao-

para rodar este projeto: 

mvn clean install 

docker-compose up 

Atentar-se que os containers docker estão com ip estático, portanto, criar a rede atraves do comando: 

docker network create \
--driver=bridge \
--subnet=172.27.0.0/16 \
--gateway=172.27.0.1 \
cateno_network1


para visualizar os containers: 

docker-compose ps 

Se tudo estiver certo, os containers estaram liberados: 

api gateway : 172.27.0.2:8080
serviço:  172.27.0.5:9091
prometheus:  172.27.0.6: 9090
grafana:  172.27.0.7: 3000
