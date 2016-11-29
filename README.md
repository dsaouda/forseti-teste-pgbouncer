## Docker Compose
    
Iniciar o postgres e o pgbouncer    
    
    docker-compose up

#Inicialização individual
##POSTGRES

    docker pull postgres

    docker run -d --name psql-teste-93 -p 25432:5432 -e POSTGRES_USER=dsaouda -e POSTGRES_PASSWORD=dsaouda postgres:9.3

##PGBOUNCER
    
    docker pull mbentley/ubuntu-pgbouncer
        
    docker run --rm -it --name pgbouncer-teste-93 -p 16432:6432 -e PG_PORT_5432_TCP_ADDR=192.168.33.10 -e PG_PORT_5432_TCP_PORT=25432 -e PG_ENV_POSTGRESQL_USER=dsaouda -e PG_ENV_POSTGRESQL_PASS=dsaouda mbentley/ubuntu-pgbouncer
    
##Referências 
[https://hub.docker.com/_/postgres/](https://hub.docker.com/_/postgres/)
[https://hub.docker.com/r/mbentley/ubuntu-pgbouncer/](https://hub.docker.com/r/mbentley/ubuntu-pgbouncer/)    