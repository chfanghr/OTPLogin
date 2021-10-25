grammar OTPLoginRules;

setup: SETUP;
login: LOGIN code=OTP;
verify: VERIFY code=OTP;

subcommand: setup|login|verify;

WS: [ \t\r\n]+ -> skip;

DIGIT: [0-9];
fragment BLOCK: [A-Za-z0-9] [A-Za-z0-9] [A-Za-z0-9] [A-Za-z0-9];

// 6 digits
OTP: (DIGIT)(DIGIT)(DIGIT)(DIGIT)(DIGIT)(DIGIT);

SETUP: 'setup';
LOGIN: 'login';
VERIFY: 'verify';