package ee.karl.homework.dao;

import ee.karl.homework.model.OperationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CalculatorDao {

    void insertOperation(OperationModel model);

    List<OperationModel> fetchPastCalculations();
}
