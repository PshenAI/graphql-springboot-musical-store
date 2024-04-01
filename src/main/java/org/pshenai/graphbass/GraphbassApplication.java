package org.pshenai.graphbass;

import org.pshenai.graphbass.entities.item.ItemEntity;
import org.pshenai.graphbass.entities.item.ItemService;
import org.pshenai.graphbass.entities.item.ItemType;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerEntity;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerService;
import org.pshenai.graphbass.entities.user.UserEntity;
import org.pshenai.graphbass.entities.user.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class GraphbassApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphbassApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserService userService, ManufacturerService manufacturerService) {
		return args -> {
			UserEntity customer1 = new UserEntity("bassPlayer@gmail.com", "password1");
			UserEntity customer2 = new UserEntity("drumPlayer@gmail.com", "password2");
			userService.saveAll(List.of(customer1, customer2));

			ManufacturerEntity manufacturer1 = new ManufacturerEntity("Ibanez");
			ManufacturerEntity manufacturer2 = new ManufacturerEntity("Fender");
			ManufacturerEntity manufacturer3 = new ManufacturerEntity("D'addario");

			ItemEntity item1 = new ItemEntity("Ibanez Roadstar II", ItemType.INSTRUMENT, "300", 1, manufacturer1);
			ItemEntity item2 = new ItemEntity("Fender Precision Bass", ItemType.INSTRUMENT, "450", 1, manufacturer2);
			ItemEntity item3 = new ItemEntity("D'addario Bass Strings", ItemType.MISCELLANEOUS, "40", 1,manufacturer3);

			manufacturer1.setItems(Collections.singletonList(item1));
			manufacturer2.setItems(Collections.singletonList(item2));
			manufacturer3.setItems(Collections.singletonList(item3));

			manufacturerService.saveAll(List.of(manufacturer1, manufacturer2, manufacturer3));
		};
	}


}
