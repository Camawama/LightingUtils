# Lighting Utils

Small lighting utilities for Forge 1.20.1, made to go with Colorful Lighting.

**Requires:** Minecraft 1.20.1, Forge 47.3.10+, on the server **and** every client (see below). No other mod. GPL-3.0.

## What it does

- **Redstone-aware tinted glass.** Vanilla's tinted glass gets a `power` block state (0 to 15) that follows the
  strongest redstone signal next to it, updated when a neighbour changes. Nothing changes in how the glass looks or
  behaves by itself; the state is there for resource packs. With Colorful Lighting, a pack's `filters.json` can give
  each power level its own light, for example glass that blocks light until it is powered:

  ```json
  {
      "minecraft:tinted_glass": {
          "default": "white;15",
          "states": { "power=15": "white;0" }
      }
  }
  ```

## Server and client

The extra block states shift the ids of every block state registered after tinted glass, so a client and a server
must both have the mod, or neither. A strict network channel (`lightingutils:presence`) makes Forge refuse a login
where only one side has it, with a mod-mismatch screen, instead of letting the player into a garbled world, and the
server list marks such a server incompatible.

## Plans

Lighting Utils, Lively Lighting and Colorful Lighting are planned to merge into one mod. There is no config yet.
