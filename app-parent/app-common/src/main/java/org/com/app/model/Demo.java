package org.com.app.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
// @AllArgsConstructor
@Data
@Accessors(chain = true)
@Entity
@ToString
public class Demo extends Model<Demo> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String demoName;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
