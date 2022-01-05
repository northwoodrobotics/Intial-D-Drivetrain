package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriftyDrive;
import frc.robot.RobotContainer;


public class DriftyDriveCommand extends CommandBase{
    DriftyDrive drive; 

    public DriftyDriveCommand(){
        addRequirements(drive);

    }

    @Override 
    public void initialize(){
        
    }

    public void execute(){
        drive.arcadeDrive(RobotContainer.driveController.leftStick.getY(), RobotContainer.driveController.leftStick.getX());

    }


    public void end(boolean interruptable){

    }
    public boolean isFinished(){
        return false;

    }
    


    
}
