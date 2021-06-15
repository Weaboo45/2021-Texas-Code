/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCheesy;
//import frc.robot.commands.DriveTank;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */

  //SUBSYSTEMS
  private final Drivetrain m_drivetrain = new Drivetrain();

  //CONTROLLERS & BUTTONS
  private final XboxController m_xbox = new XboxController(0);

  //COMMANDS
  private final DriveCheesy m_driveCheesy = new DriveCheesy(m_drivetrain, m_xbox);
  //private final DriveTank m_driveTank = new DriveTank(m_drivetrain, m_xbox);

  public RobotContainer() {
    // Configure the button bindings
    configureInitialDefaultCommands();
    configureButtonBindings();
  }
  
  private void configureInitialDefaultCommands() {
    m_drivetrain.setDefaultCommand(m_driveCheesy);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
  
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public void displayValues() {
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putNumber("velocity", -m_xbox.getY(Hand.kRight));
    SmartDashboard.putNumber("angle", m_xbox.getX(Hand.kLeft));
  }
}
