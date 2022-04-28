# Failure to serialize nested object arrays

> http://localhost:8080/flat

succeeds

> http://localhost:8080/nested

fails with

```
java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class java.lang.String ([Ljava.lang.Object; and java.lang.String are in module java.base of loader 'bootstrap')
    at io.micronaut.serde.support.serializers.CoreSerializers$2.serialize(CoreSerializers.java:63)
    at io.micronaut.serde.support.serializers.ObjectSerializer$RuntimeTypeSerializer.serialize(ObjectSerializer.java:205)
    at io.micronaut.serde.support.serdes.CustomizedObjectArraySerializer.serialize(CustomizedObjectArraySerializer.java:47)
    at io.micronaut.serde.support.serdes.CustomizedObjectArraySerializer.serialize(CustomizedObjectArraySerializer.java:31)
    at io.micronaut.serde.support.serializers.CustomizedObjectSerializer.serialize(CustomizedObjectSerializer.java:123)
    at io.micronaut.serde.jackson.JacksonJsonMapper.writeValue(JacksonJsonMapper.java:108)
    at io.micronaut.serde.jackson.JacksonJsonMapper.writeValue(JacksonJsonMapper.java:181)
    at io.micronaut.json.codec.MapperMediaTypeCodec.encode(MapperMediaTypeCodec.java:218)
    at io.micronaut.json.codec.MapperMediaTypeCodec.encode(MapperMediaTypeCodec.java:268)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyAsByteBuf(RoutingInBoundHandler.java:1408)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyWithCodec(RoutingInBoundHandler.java:1348)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeResponseBody(RoutingInBoundHandler.java:1163)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeHttpResponse(RoutingInBoundHandler.java:1006)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.access$000(RoutingInBoundHandler.java:147)
    at io.micronaut.http.server.netty.RoutingInBoundHandler$2.doOnNext(RoutingInBoundHandler.java:594)
    at io.micronaut.http.server.netty.RoutingInBoundHandler$2.doOnNext(RoutingInBoundHandler.java:586)
    at io.micronaut.core.async.subscriber.CompletionAwareSubscriber.onNext(CompletionAwareSubscriber.java:56)
...
```
