package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import DriftyLib.LazySparkMax;
import DriftyLib.SparkMaxFactory;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;


public class DriftyDrive extends SubsystemBase{
    private final LazySparkMax mLeftMaster, mRightMaster, mLeftSlave, mRightSlave; 
    private final CANPIDController mLeftPIDController, mRightPIDController;
    private final CANEncoder mLeftEncoder, mRightEncoder; 
    private final DifferentialDrive driftyDrive;

    private void configureSpark(LazySparkMax sparkMax, boolean left, boolean master){
        sparkMax.setInverted(!left);
        sparkMax.enableVoltageCompensation(12.0);
        sparkMax.setClosedLoopRampRate(0.0);
    }

    public DriftyDrive(){
        mLeftMaster = SparkMaxFactory.createDefaultSparkMax(1);
        configureSpark(mLeftMaster, true, true);
        mLeftSlave = SparkMaxFactory.createPermanentSlaveSparkMax(2, mLeftMaster);
        configureSpark(mLeftSlave, true, false);

        mRightMaster = SparkMaxFactory.createDefaultSparkMax(3);
        configureSpark(mRightMaster, false, true);

        mRightSlave = SparkMaxFactory.createPermanentSlaveSparkMax(4, mRightMaster);
        configureSpark(mRightSlave, false, false);
        mLeftEncoder = mLeftMaster.getEncoder();
        mRightEncoder = mRightMaster.getEncoder();

        mLeftPIDController = mLeftMaster.getPIDController();
        mRightPIDController = mRightMaster.getPIDController();

        mLeftPIDController.setP(Constants.DriveP);
        mLeftPIDController.setI(Constants.DriveI);
        mLeftPIDController.setD(Constants.DriveD);
        mLeftPIDController.setFF(Constants.DriveF);
        mLeftPIDController.setOutputRange(-1, 1);
        
        mRightPIDController.setP(Constants.DriveP);
        mRightPIDController.setI(Constants.DriveI);
        mRightPIDController.setD(Constants.DriveD);
        mRightPIDController.setFF(Constants.DriveF);
        mRightPIDController.setOutputRange(-1, 1);


        driftyDrive = new DifferentialDrive(mLeftMaster, mRightMaster);



    }


    public void arcadeDrive(double speed, double rotation){
        driftyDrive.arcadeDrive(speed, rotation);
    }



    





    
}
