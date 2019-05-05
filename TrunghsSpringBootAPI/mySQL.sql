CREATE DATABASE `nalstestdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `nalstestdb`.`work` (
  `WORK_ID` INT NOT NULL AUTO_INCREMENT,
  `WORK_NM` VARCHAR(45) NOT NULL,
  `WORK_START_DT` DATE NULL,
  `WORK_END_DT` DATE NULL,
  `STATUS` VARCHAR(10) NULL,
  `DEL_F` CHAR(1) GENERATED ALWAYS AS (0) VIRTUAL,
  PRIMARY KEY (`WORK_ID`),
  UNIQUE INDEX `work_id_UNIQUE` (`WORK_ID` ASC));

INSERT INTO `nalstestdb`.`work`
(`WORK_ID`,
`WORK_NM`,
`WORK_START_DT`,
`WORK_END_DT`,
`STATUS`,
`DEL_F`)
VALUES
(1,'Developer', sysdate(), sysdate(), 'Planning', 0);

INSERT INTO `nalstestdb`.`work`
(`WORK_ID`,
`WORK_NM`,
`WORK_START_DT`,
`WORK_END_DT`,
`STATUS`,
`DEL_F`)
VALUES
(2,'Tester', sysdate(), sysdate(), 'Doing', 0);

INSERT INTO `nalstestdb`.`work`
(`WORK_ID`,
`WORK_NM`,
`WORK_START_DT`,
`WORK_END_DT`,
`STATUS`,
`DEL_F`)
VALUES
(3,'Tester', sysdate(), sysdate(), 'Complete', 0);