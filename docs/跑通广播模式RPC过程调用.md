# 跑通广播模式RPC过程调用
该过程包括一个简单的RPC接口功能实现和测试调用

为了测试RPC接口的调用要创建一个测试工程，引入RPC接口的配置和同样广播模式的调用


将lottery-rpc的rpc接口包进行构建打包后，引入到lottery-test项目中，通过Dubbo设置的特定端口号和lottery-rpc中定义好的方法名、传入参数来得到lottery-interfaces 中的数据

## 第三方依赖包
在 interfaces 模块中使用Dubbo去设置端口号暴露出rpc服务，并且实现特定的rpc方法

在test工程中通过调用特定端口和方法名来访问 interfaces 远程方法

## 定义RPC接口
在lottery-rpc模块定义RPC接口，里面包括传输对象dto、传输结果Res和传输请求Req，该包会经过打包送入test工程中，通过封装这些请求对象，间接从 interfaces 模块中得到数据

## 开发RPC接口
在interfaces模块中通过service注入Dubbo，暴露出方法具体实现

在方法实现中，通过mybatis的配置得到数据库中的数据dao，并且将其封装为数据传输对象dto。

最终将dto作为res的属性写入传输给test工程的数据

## 提取数据库信息
在infrastructure模块中使用mybatis进行CRUD，得到数据库里面的数据
