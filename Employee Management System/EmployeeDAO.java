@Repository
public class EmployeeDAO {

    @Autowired private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees", new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int createEmployee(Employee emp) {
        return jdbcTemplate.update("INSERT INTO employees(name, department, position, salary) VALUES(?,?,?,?)",
                emp.getName(), emp.getDepartment(), emp.getPosition(), emp.getSalary());
    }

    public int updateEmployee(int id, Employee emp) {
        return jdbcTemplate.update("UPDATE employees SET name=?, department=?, position=?, salary=? WHERE id=?",
                emp.getName(), emp.getDepartment(), emp.getPosition(), emp.getSalary(), id);
    }

    public int deleteEmployee(int id) {
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }
}
