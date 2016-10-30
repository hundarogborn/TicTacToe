package is.ru.tictactoe.webui;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import spark.Request;
import spark.Response;
import spark.Session;

public class WebUITest {

    // Test that resetGame resets the game and redirects to root
    @Test
    public void testResetGameHandler() {
        Request mockedRequest = mock(Request.class);
        Session mockedSession = mock(Session.class);
        when(mockedRequest.session()).thenReturn(mockedSession);
        
        Response mockedResponse = mock(Response.class);

        assertNull(WebUI.resetGameHandler(mockedRequest, mockedResponse));

        verify(mockedRequest.session()).removeAttribute("game");
        verify(mockedResponse).redirect("/");
    }
}
