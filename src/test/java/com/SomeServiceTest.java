package java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.SomeService;
import org.junit.jupiter.api.Test;

class SomeServiceTest {

  @Test
  void reverseStringTest() {
    SomeService someService = new SomeService();

    assertEquals("TEST", someService.reverseString("TEST"));
  }

  @Test
  void reverseString() {
  }
}
