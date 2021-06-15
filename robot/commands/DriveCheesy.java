/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveCheesy extends CommandBase {
  /**
   * Creates a new DriveCheesy.
   */

  private Drivetrain m_drivetrain;
  private XboxController m_xbox;

  public DriveCheesy(Drivetrain drivetrain, XboxController xbox) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    m_drivetrain = drivetrain;
    m_xbox = xbox;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double velocity = -m_xbox.getY(Hand.kRight);
    //double velocity = m_xbox.getTriggerAxis(Hand.kRight) - m_xbox.getTriggerAxis(Hand.kLeft);
    double angle = m_xbox.getX(Hand.kLeft);

    m_drivetrain.cheesyDrive(velocity * 0.7, angle * 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
