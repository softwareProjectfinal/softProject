package orders;

import org.junit.Test;
import org.mockito.Mockito;
import parts.Product;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RequestTest {


    @Test
    public void RequestTest() {

        Request request = new Request(new Product("p", "p1", "ct", 10, "des"), "cust1", "bmw", "2012", "20/5/2024", false);


    }



    public class YourClassTest {

        @Test
        public void testEmail() throws AddressException, MessagingException {
            // Mocking
           /* Session mockedSession = mock(Session.class);
            when(mockedSession.getTransport( any()).thenReturn(Mockito.mock(Transport.class)));

            // Use a spy to capture the MimeMessage instance
            Request yourClassSpy = Mockito.spy(new Request(new Product(""),"","","","",false ));
            when(yourClassSpy.createSession()).thenReturn(mockedSession);

            // Call the method
            yourClassSpy.email();

            // Verify that the MimeMessage was created and sent
            verify(yourClassSpy, Mockito.times(1)).createMimeMessage();
            verify(mockedSession.getTransport("smtp"), Mockito.times(1)).sendMessage(any(MimeMessage.class), any());
        */


            Session mockedSession = mock(Session.class);
            MimeMessage mockedMessage = mock(MimeMessage.class);

            Request yourClass = new Request(new Product(""),"","","","",false);
            yourClass.email();

            // Verify that the MimeMessage was created and sent
            verify(mockedSession).getTransport("smtp");
            verify(mockedSession.getTransport("smtp")).sendMessage(mockedMessage, mockedMessage.getAllRecipients());



        }
    }

}