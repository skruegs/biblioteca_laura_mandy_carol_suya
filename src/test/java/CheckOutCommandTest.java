import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutCommandTest {
    @Test
    public void shouldCallCheckOutBookWhenRun() throws Exception {
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutCommand checkOutCommand = new CheckOutCommand(biblioteca);

        checkOutCommand.run();

        verify(biblioteca).checkOutBook("<any title>");
    }
}