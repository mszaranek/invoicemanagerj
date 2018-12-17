package solutions.autorun.invoicemanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"users", "systems", "invoices", "projRoles"})
@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "name")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView({Views.UserView.class,Views.UsersProjectsView.class})
    private String name;
    private Double monthlyCost;
    private String status;

    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    //@JsonManagedReference(value = "project_users")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<System> systems = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<Invoice> invoices = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<ProjRole> projRoles = new HashSet<>();

    public Project() {

    }
}
