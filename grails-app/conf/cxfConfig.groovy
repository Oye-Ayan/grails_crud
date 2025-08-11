
import org.apache.cxf.Bus
import org.apache.cxf.endpoint.EndpointImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import crud.AdminSoapService


@Configuration
class cxfConfig {
    Bus bus
    AdminSoapService adminSoapService


    @Bean
    EndpointImpl bookServiceEndpoint() {
        def endpoint = new EndpointImpl(bus, adminSoapService, javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
        endpoint.publish("/admin")
        return endpoint

    }
}
