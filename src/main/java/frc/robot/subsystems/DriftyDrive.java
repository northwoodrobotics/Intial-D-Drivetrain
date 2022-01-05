package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import DriftyLib.LazySparkMax;
import DriftyLib.SparkMaxFactory;

public class DriftyDrive extends SubsystemBase{
    private final LazySparkMax mLeftMaster, mRightMaster, mLeftSlave, mRightSlave; 


    private void configureSpark(LazySparkMax sparkMax, boolean left, boolean master){
        sparkMax.setInverted(!left);
        sparkMax.enableVoltageCompensation(12.0);
        sparkMax.setClosedLoopRampRate(0.0);
    }

    private DriftyDrive(){
        mLeftMaster = SparkMaxFactory.createDefaultSparkMax(1);
        configureSpark(mLeftMaster, true, true);
        mLeftSlave = SparkMaxFactory.createPermanentSlaveSparkMax(2, mLeftMaster);
        configureSpark(mLeftSlave, true, false);

        mRightMaster = SparkMaxFactory.createDefaultSparkMax(3);
        configureSpark(mRightMaster, false, true);

        mRightSlave = SparkMaxFactory.createPermanentSlaveSparkMax(4, mRightMaster);
        configureSpark(mRightSlave, false, false);
    }

    




    
    
}
