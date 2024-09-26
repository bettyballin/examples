const tracerouteData = [
  { hop: 7, host: "nyk-bb1-link.telia.net", ip: "80.91.252.162", times: [77.169, 77.401, 77.327] },
  { hop: 8, host: "kbn-bb1-link.telia.net", ip: "80.91.254.88", times: [156.938, 156.96, 156.842] },
  { hop: 9, host: "s-bb1-link.telia.net", ip: "80.91.247.160", times: [166.491, 166.425, 166.499] },
  { hop: 10, host: "s-b3-link.telia.net", ip: "80.91.247.105", times: [212.715, 212.759, 212.776] },
  { hop: 11, host: "telia-latvija-ic-132810-s-b3.c.telia.net", ip: "213.248.82.134", times: [203.272, 203.313, 203.936] }
];

for (const entry of tracerouteData) {
  console.log(`${entry.hop}  ${entry.host} (${entry.ip})  ${entry.times.map(time => time.toFixed(3)).join(' ms  ')} ms`);
}