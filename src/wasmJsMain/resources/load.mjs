import { instantiate } from './website.uninstantiated.mjs';

await wasmSetup;

instantiate({ skia: Module['asm'] });
