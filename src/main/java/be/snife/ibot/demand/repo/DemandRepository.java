package be.snife.ibot.demand.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.snife.ibot.demand.model.Demand;

@Repository
public interface DemandRepository extends CrudRepository<Demand, String> {

}
