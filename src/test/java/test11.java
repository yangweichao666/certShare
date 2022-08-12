import com.corrin.certshare.entity.FieldConvert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = test11.class)
public class test11 {
    @Test
    public void test12(){
        List<FieldConvert> fieldConvertList= new ArrayList<>();
        System.out.println(fieldConvertList.size());
    }
}
