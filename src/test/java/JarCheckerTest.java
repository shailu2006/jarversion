import com.jarversion.JarChecker;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by shailesh on 7/19/2016.
 */
@RunWith(Parameterized.class)
public class JarCheckerTest {

    private String jarFileName;
    private String expectedResult;

    public JarCheckerTest(String jarFileName, String expectedResult) {
        this.jarFileName = jarFileName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"jarv1.5.jar", "JDK 1.5"},
                {"jarv1.6.jar", "JDK 1.6"},
                {"jarv1.7.jar", "JDK 1.7"},
                {"jarv1.8.jar", "JDK 1.8"}
        });

    }


    @Test
    public void java15Test() {
        try {
            Assert.assertThat(JarChecker.getJavaVersion(getFilePath()), Is.is(expectedResult));
        } catch (IOException e) {
            Assert.fail("Exception Occurred");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Assert.fail("Exception Occurred");
            e.printStackTrace();
        }
    }

    /**
     * Get the absolute file path.
     *
     * @return
     */
    private String getFilePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(jarFileName).getFile());
        return file.getAbsolutePath();
    }
}
