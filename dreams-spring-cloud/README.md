Rabbitmq 镜像配置

0. 镜像
docker pull rabbitmq:3.7.7-management

1. 创建容器
docker run -d --name rabbitmq --hostname my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3.7.7-management

2. 进入容器
docker exec -it rabbitmq /bin/bash

3. 添加用户
rabbitmqctl add_user admin 123456

4. 添加权限
rabbitmqctl set_permissions -p "/" admin ".*" ".*" ".*"

5. 修改用户角色
rabbitmqctl set_user_tags admin administrator

