package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.AccountConverter;
import com.nlu.e.EFood.dto.AccountDTO;
import com.nlu.e.EFood.dto.ChangeResponseDTO;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.ChangeInforModel;
import com.nlu.e.EFood.model.ChangePassModel;
import com.nlu.e.EFood.repository.AccountRepository;
import com.nlu.e.EFood.service.IAccountService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accRepository;
	@Autowired
	private AccountConverter accConverter;

	@Override
	public AccountDTO save(AccountDTO accDTO) {
//		 Tạo một đối tượng AccountEntity mới để lưu trữ thông tin tài khoản
		AccountEntity accEntity = new AccountEntity();
		if (accDTO.getId() != null) {
//			Thực hiện việc tìm kiếm AccountEntity trong cơ sở dữ liệu
			Optional<AccountEntity> optionalAccountEntity = accRepository.findById(accDTO.getId());
			// Kiểm tra xem có AccountEntity được tìm thấy không
			if (optionalAccountEntity.isPresent()) {
				// Nếu có, lấy AccountEntity từ Optional và gán vào oldAccountEntity
				AccountEntity oldAccountEntity = optionalAccountEntity.get();
				// Chuyển đổi thông tin từ accDTO sang oldAccountEntity và gán vào accEntity
				accEntity = accConverter.toEntity(accDTO, oldAccountEntity);
			} else {
				// Xử lý trường hợp không tìm thấy NewEntity với id cung cấp
				// Ví dụ: throw một exception, hoặc tạo mới một NewEntity
				throw new EntityNotFoundException("Không tìm thấy AccountEntity với id: " + accDTO.getId());
			}
		} else {
			// Nếu accDTO không có ID, chỉ đơn giản là chuyển đổi accDTO thành accEntity
			accEntity = accConverter.toEntity(accDTO);
		}
		// Lưu hoặc cập nhật thông tin tài khoản trong cơ sở dữ liệu
		accEntity = accRepository.save(accEntity);
		// Chuyển đổi đối tượng accEntity đã lưu hoặc cập nhật thành AccountDTO và trả
		// về
		return accConverter.toDTO(accEntity);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountDTO> findAll() {
		List<AccountDTO> listDto = new ArrayList<>();
		for (AccountEntity entity : accRepository.findAll()) {
			AccountDTO dto = accConverter.toDTO(entity);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AccountEntity findUser(String email) {
		return accRepository.findByEmail(email);
	}

	@Override
	public AccountEntity findUserById(Long id) {
		AccountEntity accEntity = new AccountEntity();

//			Thực hiện việc tìm kiếm AccountEntity trong cơ sở dữ liệu
		Optional<AccountEntity> optionalAccountEntity = accRepository.findById(id);
		// Kiểm tra xem có AccountEntity được tìm thấy không
		if (optionalAccountEntity.isPresent()) {
			// Nếu có, lấy AccountEntity từ Optional và gán vào oldAccountEntity
			AccountEntity entity = optionalAccountEntity.get();
			accEntity = entity;
		} else {
			return null;

		}
		return accEntity;
	}

	@Override
	public ChangeResponseDTO changePassword(ChangePassModel changePassModel) {
		Optional<AccountEntity> userOptional = accRepository.findById(changePassModel.getId());

		if (!userOptional.isPresent()) {
			return new ChangeResponseDTO("ID không tồn tại.", false, null);
		}

		AccountEntity user = userOptional.get();

		if (!user.getPass().equals(changePassModel.getOldPassword())) {
			return new ChangeResponseDTO("Mật khẩu cũ không khớp.", false, null);
		}

		user.setPass(changePassModel.getNewPassword());
		accRepository.save(user);

		AccountDTO userDTO = accConverter.toDTO(user);
		return new ChangeResponseDTO("Đổi mật khẩu thành công.", true, userDTO);
	}

	@Override
	public ChangeResponseDTO changeInforUser(ChangeInforModel changeInforModel) {
		Optional<AccountEntity> userOptional = accRepository.findById(changeInforModel.getId());
		if (!userOptional.isPresent()) {
			return new ChangeResponseDTO("ID không tồn tại.", false, null);
		}
		AccountEntity user = userOptional.get();
		user.setAddress(changeInforModel.getAddress());
		user.setDob(changeInforModel.getDob());
		user.setPhone(changeInforModel.getPhone());
		user.setName(changeInforModel.getName());
		accRepository.save(user);
		AccountDTO userDTO = accConverter.toDTO(user);
		return new ChangeResponseDTO("Đổi thông tin tài khoản thành công.", true, userDTO);
	}

}
