/*
 * Copyright (c) 2017-2018, Wen Xiongchang <udc577 at 126 dot com>
 * All rights reserved.
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any
 * damages arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any
 * purpose, including commercial applications, and to alter it and
 * redistribute it freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must
 * not claim that you wrote the original software. If you use this
 * software in a product, an acknowledgment in the product documentation
 * would be appreciated but is not required.
 *
 * 2. Altered source versions must be plainly marked as such, and
 * must not be misrepresented as being the original software.
 *
 * 3. This notice may not be removed or altered from any source
 * distribution.
 */

// NOTE: The original author also uses (short/code) names listed below,
//       for convenience or for a certain purpose, at different places:
//       wenxiongchang, wxc, Damon Wen, udc577

package com.android_assistant;

public class ReturnCodes {
    private enum ValueEnum {
        /*
         * NOTE: The trailing slashes are meaningless, just for preventing the
         * IDE formatting source code automatically but ugly sometimes.
         */

        /* The basic two codes. */
        OK, //
        FAILED, //

        /* For function arguments */
        ARGUMENT_LIST_TOO_LONG, //
        INVALID_ARGUMENT, //
        INVALID_ARGUMENT_TYPE, //
        INVALID_ARGUMENT_VALUES, //
        NULL_ARGUMENTS, //
        VALUE_OUT_OF_RANGE, //

        /* For command line operations */
        COMMAND_LINE_PARAMS_INSUFFICIENT, //
        UNKNOWN_COMMAND_LINE_OPTION, //
        INVALID_COMMAND_LINE_FORMAT, //

        /* For signal operations */
        INVALID_SIGNAL, //
        SIGNAL_REGISTRATION_FAILED, //
        SIGNAL_NOT_REGISTERED, //
        SIGNAL_CAPTURE_NOT_ALLOWED, //

        /* For general objects */
        OBJECT_ALREADY_EXISTS, //
        OBJECT_DOES_NOT_EXIST, //
        EXCESS_OBJECT_COUNT, //
        OBJECT_MISMATCHED, //
        TARGET_NOT_READY, //

        /* For memory operations */
        MEMORY_ALLOCATION_FAILED, //
        SPACE_NOT_ENOUGH, //

        /* For underlying layers */
        UNDERLYING_ERROR, //
        IO_ERROR, //
        RESOURCE_UNAVAILABLE, //
        DEVICE_OR_RESOURCE_BUSY, //
        NO_SUCH_DEVICE, //
        READ_ONLY_FILE_SYSTEM, //

        /* For file operations */
        BAD_FILE_DESCRIPTOR, //
        FILE_EXISTS, //
        FILE_DOES_NOT_EXIST, //
        TOO_MANY_OPEN_FILES, //
        FILE_BUSY, //
        FILE_TOO_LARGE, //
        FILE_OR_STREAM_NOT_OPEN, //
        FILE_NAME_TOO_LONG, //
        BROKEN_PIPE, //

        /* For directory operations */
        NOT_A_DIRECTORY, //
        IS_A_DIRECTORY, //
        DIRECTORY_NOT_EMPTY, //
        DIRECTORY_EXISTS, //
        DIRECTORY_DOES_NOT_EXIST, //
        DIRECTORY_TOO_LONG, //

        /* For both file and directory operations */
        PATH_TOO_LONG, //
        INVALID_PATH, //
        NO_SUCH_FILE_OR_DIR, //

        /* For permission operations */
        PERMISSION_DENIED, //

        /* For general operations */
        OPERATION_NOT_SUPPORTED, //
        OPERATION_NOT_IMPLEMENTED, //
        OPERATION_TIMED_OUT, //
        OPERATION_IN_PROGRESS, //
        OPERATION_CANCELED, //

        /* For network operations */
        PROTOCOL_ERROR, //
        PROTOCOL_NOT_AVAILABLE, //
        PROTOCOL_NOT_SUPPORTED, //
        ADDRESS_ALREADY_IN_USE, //
        BAD_ADDRESS, //
        CANNOT_ASSIGN_ADDRESS, //
        NETWORK_DOWN, //
        NETWORK_UNREACHABLE, //
        CONNECTION_RESET_BY_PEER, //
        CONNECTION_TIMED_OUT, //
        CONNECTION_REFUSED, //
        CONNECTION_BROKEN, //
        CONNECTION_NOT_READY, //
        TCP_SELF_CONNECTION, //

        // New codes must be added before this MAX_VALUE !!!
        MAX_VALUE
    };

    /* The basic two codes. */
    public static final int OK = ValueEnum.OK.ordinal();
    public static final int FAILED = -ValueEnum.FAILED.ordinal();

    /* For function arguments */
    public static final int ARGUMENT_LIST_TOO_LONG = ValueEnum.ARGUMENT_LIST_TOO_LONG
            .ordinal();
    public static final int INVALID_ARGUMENT = ValueEnum.INVALID_ARGUMENT
            .ordinal();
    public static final int INVALID_ARGUMENT_TYPE = ValueEnum.INVALID_ARGUMENT_TYPE
            .ordinal();
    public static final int INVALID_ARGUMENT_VALUES = ValueEnum.INVALID_ARGUMENT_VALUES
            .ordinal();
    public static final int NULL_ARGUMENTS = ValueEnum.NULL_ARGUMENTS.ordinal();
    public static final int VALUE_OUT_OF_RANGE = ValueEnum.VALUE_OUT_OF_RANGE
            .ordinal();

    /* For command line operations */
    public static final int COMMAND_LINE_PARAMS_INSUFFICIENT = ValueEnum.COMMAND_LINE_PARAMS_INSUFFICIENT
            .ordinal();
    public static final int UNKNOWN_COMMAND_LINE_OPTION = ValueEnum.UNKNOWN_COMMAND_LINE_OPTION
            .ordinal();
    public static final int INVALID_COMMAND_LINE_FORMAT = ValueEnum.INVALID_COMMAND_LINE_FORMAT
            .ordinal();

    /* For signal operations */
    public static final int INVALID_SIGNAL = ValueEnum.INVALID_SIGNAL.ordinal();
    public static final int SIGNAL_REGISTRATION_FAILED = ValueEnum.SIGNAL_REGISTRATION_FAILED
            .ordinal();
    public static final int SIGNAL_NOT_REGISTERED = ValueEnum.SIGNAL_NOT_REGISTERED
            .ordinal();
    public static final int SIGNAL_CAPTURE_NOT_ALLOWED = ValueEnum.SIGNAL_CAPTURE_NOT_ALLOWED
            .ordinal();

    /* For general objects */
    public static final int OBJECT_ALREADY_EXISTS = ValueEnum.OBJECT_ALREADY_EXISTS
            .ordinal();
    public static final int OBJECT_DOES_NOT_EXIST = ValueEnum.OBJECT_DOES_NOT_EXIST
            .ordinal();
    public static final int EXCESS_OBJECT_COUNT = ValueEnum.EXCESS_OBJECT_COUNT
            .ordinal();
    public static final int OBJECT_MISMATCHED = ValueEnum.OBJECT_MISMATCHED
            .ordinal();
    public static final int TARGET_NOT_READY = ValueEnum.TARGET_NOT_READY
            .ordinal();

    /* For memory operations */
    public static final int MEMORY_ALLOCATION_FAILED = ValueEnum.MEMORY_ALLOCATION_FAILED
            .ordinal();
    public static final int SPACE_NOT_ENOUGH = ValueEnum.SPACE_NOT_ENOUGH
            .ordinal();

    /* For underlying layers */
    public static final int UNDERLYING_ERROR = ValueEnum.UNDERLYING_ERROR
            .ordinal();
    public static final int IO_ERROR = ValueEnum.IO_ERROR.ordinal();
    public static final int RESOURCE_UNAVAILABLE = ValueEnum.RESOURCE_UNAVAILABLE
            .ordinal();
    public static final int DEVICE_OR_RESOURCE_BUSY = ValueEnum.DEVICE_OR_RESOURCE_BUSY
            .ordinal();
    public static final int NO_SUCH_DEVICE = ValueEnum.NO_SUCH_DEVICE.ordinal();
    public static final int READ_ONLY_FILE_SYSTEM = ValueEnum.READ_ONLY_FILE_SYSTEM
            .ordinal();

    /* For file operations */
    public static final int BAD_FILE_DESCRIPTOR = ValueEnum.BAD_FILE_DESCRIPTOR
            .ordinal();
    public static final int FILE_EXISTS = ValueEnum.FILE_EXISTS.ordinal();
    public static final int FILE_DOES_NOT_EXIST = ValueEnum.FILE_DOES_NOT_EXIST
            .ordinal();
    public static final int TOO_MANY_OPEN_FILES = ValueEnum.TOO_MANY_OPEN_FILES
            .ordinal();
    public static final int FILE_BUSY = ValueEnum.FILE_BUSY.ordinal();
    public static final int FILE_TOO_LARGE = ValueEnum.FILE_TOO_LARGE.ordinal();
    public static final int FILE_OR_STREAM_NOT_OPEN = ValueEnum.FILE_OR_STREAM_NOT_OPEN
            .ordinal();
    public static final int FILE_NAME_TOO_LONG = ValueEnum.FILE_NAME_TOO_LONG
            .ordinal();
    public static final int BROKEN_PIPE = ValueEnum.BROKEN_PIPE.ordinal();

    /* For directory operations */
    public static final int NOT_A_DIRECTORY = ValueEnum.NOT_A_DIRECTORY
            .ordinal();
    public static final int IS_A_DIRECTORY = ValueEnum.IS_A_DIRECTORY.ordinal();
    public static final int DIRECTORY_NOT_EMPTY = ValueEnum.DIRECTORY_NOT_EMPTY
            .ordinal();
    public static final int DIRECTORY_EXISTS = ValueEnum.DIRECTORY_EXISTS
            .ordinal();
    public static final int DIRECTORY_DOES_NOT_EXIST = ValueEnum.DIRECTORY_DOES_NOT_EXIST
            .ordinal();
    public static final int DIRECTORY_TOO_LONG = ValueEnum.DIRECTORY_TOO_LONG
            .ordinal();

    /* For both file and directory operations */
    public static final int PATH_TOO_LONG = ValueEnum.PATH_TOO_LONG.ordinal();
    public static final int INVALID_PATH = ValueEnum.INVALID_PATH.ordinal();

    /* For permission operations */
    public static final int PERMISSION_DENIED = ValueEnum.PERMISSION_DENIED
            .ordinal();

    /* For general operations */
    public static final int OPERATION_NOT_SUPPORTED = ValueEnum.OPERATION_NOT_SUPPORTED
            .ordinal();
    public static final int OPERATION_NOT_IMPLEMENTED = ValueEnum.OPERATION_NOT_IMPLEMENTED
            .ordinal();
    public static final int OPERATION_TIMED_OUT = ValueEnum.OPERATION_TIMED_OUT
            .ordinal();
    public static final int OPERATION_IN_PROGRESS = ValueEnum.OPERATION_IN_PROGRESS
            .ordinal();
    public static final int OPERATION_CANCELED = ValueEnum.OPERATION_CANCELED
            .ordinal();

    /* For network operations */
    public static final int PROTOCOL_ERROR = ValueEnum.PROTOCOL_ERROR.ordinal();
    public static final int PROTOCOL_NOT_AVAILABLE = ValueEnum.PROTOCOL_NOT_AVAILABLE
            .ordinal();
    public static final int PROTOCOL_NOT_SUPPORTED = ValueEnum.PROTOCOL_NOT_SUPPORTED
            .ordinal();
    public static final int ADDRESS_ALREADY_IN_USE = ValueEnum.ADDRESS_ALREADY_IN_USE
            .ordinal();
    public static final int BAD_ADDRESS = ValueEnum.BAD_ADDRESS.ordinal();
    public static final int CANNOT_ASSIGN_ADDRESS = ValueEnum.CANNOT_ASSIGN_ADDRESS
            .ordinal();
    public static final int NETWORK_DOWN = ValueEnum.NETWORK_DOWN.ordinal();
    public static final int NETWORK_UNREACHABLE = ValueEnum.NETWORK_UNREACHABLE
            .ordinal();
    public static final int CONNECTION_RESET_BY_PEER = ValueEnum.CONNECTION_RESET_BY_PEER
            .ordinal();
    public static final int CONNECTION_TIMED_OUT = ValueEnum.CONNECTION_TIMED_OUT
            .ordinal();
    public static final int CONNECTION_REFUSED = ValueEnum.CONNECTION_REFUSED
            .ordinal();
    public static final int CONNECTION_BROKEN = ValueEnum.CONNECTION_BROKEN
            .ordinal();
    public static final int CONNECTION_NOT_READY = ValueEnum.CONNECTION_NOT_READY
            .ordinal();
    public static final int TCP_SELF_CONNECTION = ValueEnum.TCP_SELF_CONNECTION
            .ordinal();

    public static String description(int returnCode) {
        for (ValueEnum e : ValueEnum.values()) {
            if (returnCode == -e.ordinal())
                return e.toString();
        }

        return "Unknown return code " + String.valueOf(returnCode);
    }
}
