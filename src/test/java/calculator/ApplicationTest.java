package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 정상적인_입력_1(){
        String input = "1,2,3,4";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    public void 정상적인_입력_2(){
        String input = "1;2,3;4";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    public void 커스텀_지정자만_있는_경우(){
        String input = "//;\\n";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    public void 빈_문자가_입력되는_경우(){
        String input = "";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
