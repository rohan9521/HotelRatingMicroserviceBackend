public interface RatingRepository extends JpaRepository<Rating,String>{
	
    @Query("UPDATE ratings r SET r.userId=rating.userId , r.hotelId=rating.hotelId,r.rating=rating.rating,r.feedback=rating.feedback")
    void updateRating(Rating rating)
}