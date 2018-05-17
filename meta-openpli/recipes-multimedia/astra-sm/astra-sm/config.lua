#!/usr/bin/astra

-- Config script example to stream ZeonBood T2-MI services from Astra 4A & SES 5 (4.9E)
-- For other providers or services change settings with yours.
-- To use this config add channels in bouquet in the following format:
-- #SERVICE 1:0:1:B:0:0:0:0:0:0:http%3a//0.0.0.0%3a9999/zombi/11:Інтер
-- #DESCRIPTION Інтер
-- #SERVICE 1:0:1:C:0:0:0:0:0:0:http%3a//0.0.0.0%3a9999/zombi/12:Україна
-- #DESCRIPTION Україна
-- etc...
--
-- Аdd in /etc/enigma2/lamedb
-- 00310000:0064:2324
-- 	s 12188000:30000000:0:4:49:2:0:1:2:0:2:10:1:0
-- /
-- 00310000:00c8:2324
-- 	s 12188000:30000000:0:4:49:2:0:1:2:0:2:20:1:0
-- /
-- 00310000:012c:2324
-- 	s 12341000:30000000:0:3:49:2:0:1:2:0:2:30:1:0
-- /
-- 
-- 0320:00310000:0064:2324:1:0:0
-- ZeonBud-MX1
-- p:ZeonBud,c:031000,c:151000,f:1
-- 0320:00310000:00c8:2324:1:0:0
-- ZeonBud-MX2
-- p:ZeonBud,c:031000,c:151000,f:1
-- 0320:00310000:012c:2324:1:0:0
-- ZeonBud-MX3
-- p:ZeonBud,c:031000,c:151000,f:1

log.set({ stdout = false, debug = false, syslog = "astra", })

f12188isi10 = make_t2mi_decap({
        name = "12188H ISI10 T2-MI PLP0",
        input = "http://127.0.0.1:8001/1:0:1:320:64:2324:310000:0:0:0:",
        plp = 0,
        pnr = 0,
        pid = 4096,
})

f12188isi20 = make_t2mi_decap({
        name = "12188H ISI20 T2-MI PLP0",
        input = "http://127.0.0.1:8001/1:0:1:320:C8:2324:310000:0:0:0:",
        plp = 0,
        pnr = 0,
        pid = 4096,
})

f12341isi30 = make_t2mi_decap({
        name = "12341H ISI30 T2-MI PLP0",
        input = "http://127.0.0.1:8001/1:0:1:320:12C:2324:310000:0:0:0:",
        plp = 0,
        pnr = 0,
        pid = 4096,
})

make_channel({                                                         
        name = "ZeonBud-MX1", input = { "t2mi://f12188isi10", },           
        output = { "http://0.0.0.0:9999/zombi/mx1", },             
})

make_channel({                                                         
        name = "ZeonBud-MX2", input = { "t2mi://f12188isi20", },           
        output = { "http://0.0.0.0:9999/zombi/mx2", },             
})

make_channel({                                                         
        name = "ZeonBud-MX3", input = { "t2mi://f12341isi30", },           
        output = { "http://0.0.0.0:9999/zombi/mx3", },             
})

make_channel({
    name = "Інтер",
    input = {
        "t2mi://f12188isi10#pnr=11"
    },
    output = {
        "http://0.0.0.0:9999/zombi/11"
    }
})

make_channel({
    name = "Україна",
    input = {
        "t2mi://f12188isi10#pnr=12"
    },
    output = {
        "http://0.0.0.0:9999/zombi/12"
    }
})

make_channel({
    name = "1+1",
    input = {
        "t2mi://f12188isi10#pnr=13"
    },
    output = {
        "http://0.0.0.0:9999/zombi/13"
    }
})

make_channel({
    name = "НТН",
    input = {
        "t2mi://f12188isi10#pnr=14"
    },
    output = {
        "http://0.0.0.0:9999/zombi/14"
    }
})

make_channel({
    name = "K-1",
    input = {
        "t2mi://f12188isi10#pnr=15"
    },
    output = {
        "http://0.0.0.0:9999/zombi/15"
    }
})

make_channel({
    name = "ПЕРШИЙ Т2",
    input = {
        "t2mi://f12188isi10#pnr=16"
    },
    output = {
        "http://0.0.0.0:9999/zombi/16"
    }
})

make_channel({
    name = "ICTV",
    input = {
        "t2mi://f12188isi10#pnr=17"
    },
    output = {
        "http://0.0.0.0:9999/zombi/17"
    }
})

make_channel({
    name = "Enter-фільм",
    input = {
        "t2mi://f12188isi10#pnr=18"
    },
    output = {
        "http://0.0.0.0:9999/zombi/18"
    }
})

make_channel({
    name = "ZOOM",
    input = {
        "t2mi://f12188isi20#pnr=21"
    },
    output = {
        "http://0.0.0.0:9999/zombi/21"
    }
})

make_channel({
    name = "Кіноточка",
    input = {
        "t2mi://f12188isi20#pnr=22"
    },
    output = {
        "http://0.0.0.0:9999/zombi/22"
    }
})

make_channel({
    name = "СТБ",
    input = {
        "t2mi://f12188isi20#pnr=23"
    },
    output = {
        "http://0.0.0.0:9999/zombi/23"
    }
})

make_channel({
    name = "ТЕТ",
    input = {
        "t2mi://f12188isi20#pnr=24"
    },
    output = {
        "http://0.0.0.0:9999/zombi/24"
    }
})

make_channel({
    name = "К-2",
    input = {
        "t2mi://f12188isi20#pnr=25"
    },
    output = {
        "http://0.0.0.0:9999/zombi/25"
    }
})

make_channel({
    name = "Новий канал",
    input = {
        "t2mi://f12188isi20#pnr=26"
    },
    output = {
        "http://0.0.0.0:9999/zombi/26"
    }
})

make_channel({
    name = "М-1",
    input = {
        "t2mi://f12188isi20#pnr=27"
    },
    output = {
        "http://0.0.0.0:9999/zombi/27"
    }
})

make_channel({
    name = "5 канал",
    input = {
        "t2mi://f12188isi20#pnr=28"
    },
    output = {
        "http://0.0.0.0:9999/zombi/28"
    }
})

make_channel({
    name = "Мега",
    input = {
        "t2mi://f12341isi30#pnr=31"
    },
    output = {
        "http://0.0.0.0:9999/zombi/31"
    }
})

make_channel({
    name = "Pixel",
    input = {
        "t2mi://f12341isi30#pnr=32"
    },
    output = {
        "http://0.0.0.0:9999/zombi/32"
    }
})

make_channel({
    name = "XSPORT",
    input = {
        "t2mi://f12341isi30#pnr=33"
    },
    output = {
        "http://0.0.0.0:9999/zombi/33"
    }
})

make_channel({
    name = "НЛО ТБ",
    input = {
        "t2mi://f12341isi30#pnr=34"
    },
    output = {
        "http://0.0.0.0:9999/zombi/34"
    }
})

make_channel({
    name = "2+2",
    input = {
        "t2mi://f12341isi30#pnr=35"
    },
    output = {
        "http://0.0.0.0:9999/zombi/35"
    }
})

make_channel({
    name = "Z",
    input = {
        "t2mi://f12341isi30#pnr=36"
    },
    output = {
        "http://0.0.0.0:9999/zombi/36"
    }
})

make_channel({
    name = "ЕСПРЕСО TV",
    input = {
        "t2mi://f12341isi30#pnr=37"
    },
    output = {
        "http://0.0.0.0:9999/zombi/37"
    }
})

make_channel({
    name = "BUSINESS",
    input = {
        "t2mi://f12341isi30#pnr=38"
    },
    output = {
        "http://0.0.0.0:9999/zombi/38"
    }
})
