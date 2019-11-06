

CREATE TABLE `attendance` (
  `memberId` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `startTime` varchar(10) DEFAULT NULL,
  `endTime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`memberId`,`date`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `membership` (`memberID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `equipments` (
  `equipId` varchar(10) NOT NULL,
  `equipName` varchar(70) DEFAULT NULL,
  `buyingPrice` decimal(8,2) DEFAULT NULL,
  `buyingDate` varchar(20) DEFAULT NULL,
  `warrantyPeriod` varchar(20) DEFAULT NULL,
  `lifeTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `exercise` (
  `bodyPart` varchar(50) NOT NULL,
  `exerciseName` varchar(30) NOT NULL,
  `reps` varchar(10) DEFAULT NULL,
  `machineId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bodyPart`),
  KEY `machineId` (`machineId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `instructors` (
  `empId` varchar(20) NOT NULL,
  `name` varchar(70) NOT NULL,
  `shift` varchar(50) DEFAULT NULL,
  `contactNo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `membership` (
  `memberID` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `contactNo` varchar(10) DEFAULT NULL,
  `bmiRange` varchar(20) DEFAULT NULL,
  `fatRange` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `scheduleNo` int(11) DEFAULT NULL,
  `notifications` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`memberID`),
  KEY `membership_schedules_scheduleNo_fk` (`scheduleNo`),
  CONSTRAINT `memberID` FOREIGN KEY (`memberID`) REFERENCES `membershipDetails` (`memberID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `membership_schedules_scheduleNo_fk` FOREIGN KEY (`scheduleNo`) REFERENCES `schedules` (`scheduleNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `membershipDetails` (
  `memberID` varchar(30) NOT NULL,
  `instructId` varchar(70) NOT NULL,
  `type` varchar(20) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `expDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`memberID`),
  KEY `membershipDetails_membershipTypes_duration_fk` (`type`),
  KEY `membershipDetails_instructors_empId_fk` (`instructId`),
  CONSTRAINT `membershipDetails_instructors_empId_fk` FOREIGN KEY (`instructId`) REFERENCES `instructors` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `membershipDetails_membershipTypes_duration_fk` FOREIGN KEY (`type`) REFERENCES `membershipTypes` (`duration`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `membershipTypes` (
  `duration` varchar(20) NOT NULL,
  `price` double(8,2) DEFAULT NULL,
  `branchName` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `bmiRanges` varchar(10) DEFAULT NULL,
  `fatRanges` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`duration`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `schedules` (
  `scheduleNo` int(11) NOT NULL,
  `bodyPart` varchar(50) DEFAULT NULL,
  `exercise01` varchar(70) DEFAULT NULL,
  `exercise02` varchar(70) DEFAULT NULL,
  `exercise03` varchar(70) DEFAULT NULL,
  `reps` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`scheduleNo`),
  KEY `schedules_exercise_bodyPart_fk` (`bodyPart`),
  CONSTRAINT `schedules_exercise_bodyPart_fk` FOREIGN KEY (`bodyPart`) REFERENCES `exercise` (`bodyPart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


