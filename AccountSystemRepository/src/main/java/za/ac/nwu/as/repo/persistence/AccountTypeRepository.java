package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.persistence.AccountTypeDto;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypeDto, Long> {
}
