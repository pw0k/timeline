# timeline

Classic system design example Twitter/Facebook timeline/feed 

## start:

//todo надо перепроверить !!!
```shell
docker-compose up -d --build timeline
```

## save 
localhost:8080/ ???
{
"title" : "t1",
"description" : "d1"
}

# for test purpose
## cleaning db 
```shell
drop table if exists databasechangelog;
drop table if exists tm_user cascade;
drop table if exists post cascade;
drop table if exists follow cascade;
drop table if exists tm_group cascade;
```