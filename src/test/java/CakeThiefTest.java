package test.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import main.java.CakeThief;
import main.java.cakeType.CakeType;
import org.junit.Test;

public class CakeThiefTest {

  private static final CakeThief cakeThief = new CakeThief();

  @Test
  public void shouldTestForMaxValue(){
    //given
    CakeType[] cakeTypes = new CakeType[3];
    cakeTypes[0] = new CakeType(10, 60);
    cakeTypes[1] = new CakeType(20, 100);
    cakeTypes[2] = new CakeType(30, 120);

    //when
    int maxValue = cakeThief.maxDuffelBagValue(cakeTypes, 50);

    //then
    assertThat(maxValue, equalTo(220));
  }

}
