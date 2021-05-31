package quartz.cluster.demo.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QuartzTrigger {
    String cron() default "";

    String name() default "";

    String group() default "";
}

