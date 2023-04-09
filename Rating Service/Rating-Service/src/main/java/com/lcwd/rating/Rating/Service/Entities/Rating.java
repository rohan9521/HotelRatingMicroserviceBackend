@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("ratings")
public class Rating{
    @Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}