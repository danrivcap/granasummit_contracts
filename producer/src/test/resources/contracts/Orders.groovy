import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return an order"
    name "get order"
    request{
        method GET()
        url("/order") {
            queryParameters {
                parameter("number", value(consumer(matching("[0-9]+")), producer(3)))
            }
        }
    }
    response {
        headers {
            contentType(applicationJson())
        }
        body(
                id:fromRequest().query("number"),
                name:anyNonEmptyString(),
        )
        status 200
    }
}