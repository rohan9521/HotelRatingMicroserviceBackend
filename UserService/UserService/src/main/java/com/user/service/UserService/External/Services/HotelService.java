
@FeignClient(name="HOTEL-Service")
public interface HotelService{
    @GetMapping("hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId); 
    //@PathVariable("hotelId") is because if hotelId name from getmapping 
    //doesnt match with variable name then else no need to right;
}