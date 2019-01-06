package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="BasicLinearOp",group = "LinearOpMode")
public class PiD extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public final double drivePidKp = 1;     // Tuning variable for PID.
    public final double drivePidTi = 1.0;   // Eliminate integral error in 1 sec.
    public final double drivePidTd = 0.3;   // Account for error in 0.1 sec.
    public long maxWheelSpeed;
    // Protect against integral windup by limiting integral term.
    public final double drivePidIntMax = maxWheelSpeed;  // Limit to max speed.
    public final double driveOutMax = 1;  // Motor output limited to 100%.

    @Override
    public void runOpMode() {
        final double ticksPerRevolution = 1000;  // Get for your motor and gearing.
        final double prevTime;  // The last time loop() was called.
        double prevTime1;
        final int prevLeftEncoderPosition;   // Encoder tick at last call to loop().
        int prevLeftEncoderPosition1;
        final int prevRightEncoderPosition;  // Encoder tick at last call to loop().
        int prevRightEncoderPosition1;
        //tells the user that the OpMode is initialized
        telemetry.addData("Status","Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        //(here you are waiting for the player to press the play button)
        runtime.reset();

        while (opModeIsActive()) {
            leftDrive.setPower(0.5);
            rightDrive.setPower(1);
            sleep(1000);

            telemetry.addData("Status","Run Time:"+ runtime.toString());
            telemetry.update();
        }
    }

    public double DrivePidKp() {
        return drivePidKp;
    }

    public double DrivePidTi() {
        return drivePidTi;
    }

    public double getDrivePidTd() {
        return drivePidTd;
    }

    public void setMaxWheelSpeed(long maxWheelSpeed) {
        this.maxWheelSpeed = maxWheelSpeed;
    }

    public double DrivePidIntMax() {
        return drivePidIntMax;
    }

    public double DriveOutMax() {
        return driveOutMax;
    }
}
