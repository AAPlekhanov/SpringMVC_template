package other;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MyFlowBean implements Serializable {

    public void printInt(int i) {
        System.out.printf("Int = " + i);
    }

}
