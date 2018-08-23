
package clientesga.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientesga.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarPersonas_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listarPersonas");
    private final static QName _ListarPersonasResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listarPersonasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientesga.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarPersonas }
     * 
     */
    public ListarPersonas createListarPersonas() {
        return new ListarPersonas();
    }

    /**
     * Create an instance of {@link ListarPersonasResponse }
     * 
     */
    public ListarPersonasResponse createListarPersonasResponse() {
        return new ListarPersonasResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listarPersonas")
    public JAXBElement<ListarPersonas> createListarPersonas(ListarPersonas value) {
        return new JAXBElement<ListarPersonas>(_ListarPersonas_QNAME, ListarPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listarPersonasResponse")
    public JAXBElement<ListarPersonasResponse> createListarPersonasResponse(ListarPersonasResponse value) {
        return new JAXBElement<ListarPersonasResponse>(_ListarPersonasResponse_QNAME, ListarPersonasResponse.class, null, value);
    }

}
