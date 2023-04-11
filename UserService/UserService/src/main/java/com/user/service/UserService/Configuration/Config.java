@Bean
public class Config{

    @Bean
    public RestTemplate getRestTemplate{
        return new RestTemplate();
    }
}