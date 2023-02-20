package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BestsellerRepository {
    List<Bestseller> findAll();
    Bestseller findById(int id);
    Bestseller save(Bestseller bideojokoa);
    long delete(int id);
}