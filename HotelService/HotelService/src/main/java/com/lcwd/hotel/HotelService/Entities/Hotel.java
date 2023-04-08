@Table(name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
@Id
@Column(name="ID")
private String id;

@Column(name="NAME")
private String name;

@Column(name="LOCATION")
private String location;

@Column(name="ABOUT")
private String about;

}