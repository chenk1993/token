# token
token
什么是JWT
JSON Web Token 简称JWT。
一个JWT实际上就是一个字符串，它由三部分组成，头部、载荷与签名。
JWT生成的token是这样的
eyJpc3MiOiJKb2huI.eyJpc3MiOiJ.Kb2huIFd1IEp


生成的token，是3段，用.连接。

头部
用于描述关于该JWT的最基本的信息，例如其类型以及签名所用的算法等。这也可以被表示成一个JSON对象。
例如：
{
   "typ": "JWT",
  "alg": "HS256"
}

载荷
其实就是自定义的数据，一般存储用户Id，过期时间等信息。也就是JWT的核心所在，因为这些数据就是使后端知道此token是哪个用户已经登录的凭证。而且这些数据是存在token里面的，由前端携带，所以后端几乎不需要保存任何数据。
例如：
{
  "uid": "xxxxidid",  //用户id
  "exp": "12121212"  //过期时间
}

签名
签名其实就是：
1.头部和载荷各自base64加密后用.连接起来，然后就形成了xxx.xx的前两段token。
2.最后一段token的形成是，前两段加入一个密匙用HS256算法或者其他算法加密形成。

所以token3段的形成就是在签名处形成的。
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






