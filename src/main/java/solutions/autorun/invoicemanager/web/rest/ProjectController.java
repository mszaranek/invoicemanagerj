package solutions.autorun.invoicemanager.web.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import solutions.autorun.academy.model.Invoice;
import solutions.autorun.academy.model.Project;
import solutions.autorun.academy.model.Task;
import solutions.autorun.academy.services.ProjectService;
import solutions.autorun.academy.views.Views;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(value = "/projects")
    public ResponseEntity<Set<Project>> showProjects() {
        long startTime = System.currentTimeMillis();
        Set<Project> projects = projectService.getProjects();
        long estimatedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Time: " + estimatedTime);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping(value = "/projects")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_MANAGER')")
    public ResponseEntity<Void> createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "project/{id}")
    public ResponseEntity<Project> findProject(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.findProjectById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/projects")
    public ResponseEntity<Void> updateProject(@RequestBody Project project) {
        projectService.findProjectById(project.getId());
        projectService.updateProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "project/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "project/{id}/invoices")
    @JsonView(Views.InvoiceView.class)
    public ResponseEntity<Set<Invoice>> findProjectsInvoices(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.findProjectById(id).getInvoices(), HttpStatus.OK);
    }

    @GetMapping(value = "project/{id}/tasks")
    @JsonView(Views.ProjectsTaskView.class)
    public ResponseEntity<Set<Task>> findProjectsTasks(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.getTasks(id), HttpStatus.OK);
    }
}
