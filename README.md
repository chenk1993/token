# token
token

项目 Maven 配置
![image](https://github.com/chenk1993/token/blob/master/img/2.png)
![image](https://github.com/chenk1993/token/blob/master/img/3.png)


登陆流程;
发送带有用户手机和密码的post登陆请求时，将会调用登陆服务接口
![image](https://github.com/chenk1993/token/blob/master/img/4.png)
通过账号信息抽取出userId、psw等信息加密组成一个payload，与加密后的header以及密钥secret组装成一个JWT，服务端会根据这个secret密钥进行生成token和验证
![image](https://github.com/chenk1993/token/blob/master/img/5.png)
登陆成功时，会取得正确的用户数据，以及token
![image](https://github.com/chenk1993/token/blob/master/img/1.png)

验证流程：
http请求传到后台，AuthenticationInterceptor会检查是否有passtoken注释，有则跳过认证；
如果没有跳过认证注释，会验证是否有token，根据token解析出user，再从token中根据secret密钥，看和之前生成token是否一致。
![image](https://github.com/chenk1993/token/blob/master/img/7.png)
![image](https://github.com/chenk1993/token/blob/master/img/8.png)

![image](https://github.com/chenk1993/token/blob/master/img/6.png)






